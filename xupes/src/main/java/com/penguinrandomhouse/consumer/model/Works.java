package com.penguinrandomhouse.consumer.model;

import java.util.List;

/**
 * POJO representing array of Work elements.
 *
 * @author Karar
 * @since 2020-01-20
 */
public class Works {

    /** List of Work, can be null or empty */
	private List<Work> work;

    /** Default constructor. */
    public Works() {
    }

	public List<Work> getWork() {
		return work;
	}

	public void setWork(List<Work> work) {
		this.work = work;
	}    
}
