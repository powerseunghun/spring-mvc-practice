package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Component
@Data
@RequiredArgsConstructor 
public class SampleHotel {
	@NonNull
	private Chef chef;
}
