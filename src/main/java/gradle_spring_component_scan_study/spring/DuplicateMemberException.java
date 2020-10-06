package gradle_spring_component_scan_study.spring;

import org.springframework.stereotype.Component;

public class DuplicateMemberException extends RuntimeException {

	public DuplicateMemberException(String message) {
		super(message);
	}

}
