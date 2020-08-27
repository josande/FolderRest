package entities;

import app.entities.folder.Folder;
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
    @Test
    public void testFolderEquals() {
        Folder folder1 = Folder.builder().name("folderName1")
                .description("my fancy folder")
                .build();
        Folder folder2 = Folder.builder().name("folderName2")
                .description("my fancy folder")
                .build();
        assertNotEquals(folder1, folder2);
    }
    @Test
    public void testFolderEqualsWithSameName() {
        Folder folder1 = Folder.builder().name("folderName")
                .build();
        Folder folder2 = Folder.builder().name("folderName")
                .build();
        assertNotEquals(folder1, folder2);
    }
    @Test
    public void testFolderEqualsWithSameId() {
        Folder folder1 = Folder.builder().id(1L)
                .build();
        Folder folder2 = Folder.builder().id(1L)
                .build();
        assertNotEquals(folder1, folder2);
    }
}