package entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FolderTest {

    @Test
    public void createNewFolder() {
        Folder folder = Folder.builder().name("folderName")
                                        .description("my fancy folder")
                                        .build();
        assertEquals("folderName", folder.getName());
        assertEquals("my fancy folder", folder.getDescription());
    }

}