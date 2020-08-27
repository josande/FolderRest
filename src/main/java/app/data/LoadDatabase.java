package app.data;

import app.entities.folder.Folder;
import app.entities.folder.FolderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(FolderRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(Folder.builder().name("My Public folder").description("Look, no secrets").build()));
            log.info("Preloading " + repository.save(Folder.builder().name("My hidden folder").description("Contain old love letters").build()));
        };
    }

}
