package com.penguinrandomhouse.consumer.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.penguinrandomhouse.consumer.service.BookService;

/**
 * Book service management test.
 *
 * @author Karar
 * @since 2020-01-20
 */
@SpringBootTest
public class BookServiceTest {

    /** Book service. */
    @Autowired
    private BookService bookService;

    /**
     * Test retrieving authors by book name.
     */
    @Test
    public void test_authors() {

        // test result with single Work data
    	assertTrue(bookService.getAuthorsByBookName("The Amazing Book Is Not on Fire: The World of Dan and Phil").contains("Dan Howell"));

    	assertTrue(bookService.getAuthorsByBookName("Paw Patrol 5-Minute Stories Collection (Paw Patrol)").contains("RANDOM HOUSE"));

        // test result with multiple Work data
    	assertTrue(bookService.getAuthorsByBookName("Educated").contains("Sheilah Graham"));
    	assertTrue(bookService.getAuthorsByBookName("Educated").contains("Alfie Kohn"));

        // test empty result
        assertNull(bookService.getAuthorsByBookName("$@#$%!@^$!^%@%$^!"));
    }
}
