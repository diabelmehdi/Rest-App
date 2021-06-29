package com.example.RestApp.MindsApp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import org.powermock.api.mockito.PowerMockito;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {BusinessClass.class})
@ExtendWith(SpringExtension.class)
public class BusinessClassTest {
    @Autowired
    private BusinessClass businessClass;

    @Test
    public void testGetinfo() throws FileNotFoundException {
        // Arrange, Act and Assert

        assertTrue(this.businessClass.getinfo("Searchcode").isEmpty());
    }

    @Test
    public void testGetinfo2() throws Exception {
        // here you can choose another file to Mock data (for testing purposes )
        FileInputStream file = new FileInputStream("C:\\Users\\DIAB\\Desktop\\BDT.txt");

        PowerMockito.whenNew(FileInputStream.class).withAnyArguments().thenReturn(file);
        // Arrange and Act
        List<String> actualGetinfoResult = this.businessClass.getinfo("0178480");

        // Assert
        assertEquals(4, actualGetinfoResult.size());
        assertEquals("Diagnose", actualGetinfoResult.get(0));
        assertEquals("========", actualGetinfoResult.get(1));
        assertEquals("Therapie", actualGetinfoResult.get(2));
        assertEquals("========", actualGetinfoResult.get(3));
    }
}

