package com.penguinrandomhouse.consumer.service;

import com.penguinrandomhouse.consumer.model.Work;
import com.penguinrandomhouse.consumer.rest_client.WorkClient;
import com.penguinrandomhouse.consumer.util.NameUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Book management service.
 *
 * @author Karar
 * @since 2020-01-20
 */
@Service
public class BookService {

    /** Rest client for retrieving Work data. */
    @Autowired
    private WorkClient workClient;

    /**
     * Get authors information by book name.
     * Convert the authors name into [firstName lastName] format.
     *
     * @param bookName The book name
     * @return Name of authors
     */
    public Set<String> getAuthorsByBookName(String bookName) {
        Optional<List<Work>> result = workClient.findByName(bookName);
        if (!result.isPresent()) {
            return null;
        }

        List<Work> work = result.get();
        Set<String> authors = work.stream().map(title -> title.getAuthorweb()).collect(Collectors.toSet());
        return NameUtil.convert(authors);
    }
}
