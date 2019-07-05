package com.juanmorschrott.hotel.configuration;

import com.juanmorschrott.hotel.batch.HotelItemProcessor;
import com.juanmorschrott.hotel.batch.JobCompletionNotificationListener;
import com.juanmorschrott.hotel.model.Hotel;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    // tag::readerwriterprocessor[]
    @Bean
    public FlatFileItemReader<Hotel> reader() {
        return new FlatFileItemReaderBuilder<Hotel>()
                .name("hotelItemReader")
                .resource(new ClassPathResource("hotel-reviews.csv"))
                .delimited().names(new String[]{"id", "address", "city", "country", "name"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper<Hotel>() {{
                    setTargetType(Hotel.class);
                }})
                .build();
    }

    @Bean
    public HotelItemProcessor processor() {
        return new HotelItemProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Hotel> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Hotel>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO hotel (id, address, city, country, name) VALUES (:id, :address, :city, :country, :name)")
                .dataSource(dataSource)
                .build();
    }
    // end::readerwriterprocessor[]

    // tag::jobstep[]
    @Bean
    public Job importHotelJob(JobCompletionNotificationListener listener, Step step1) {
        return jobBuilderFactory.get("importHotelJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1(JdbcBatchItemWriter<Hotel> writer) {
        return stepBuilderFactory.get("step1")
                .<Hotel, Hotel> chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer)
                .build();
    }
    // end::jobstep[]

}
