package com.example.application.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Value;

@Value
public class FilmShortDTO {

	@JsonProperty("id")
	private int filmId;
	@JsonProperty("titulo")
	private String title;

}
