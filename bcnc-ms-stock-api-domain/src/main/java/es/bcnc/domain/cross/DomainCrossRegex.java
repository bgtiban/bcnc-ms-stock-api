package es.bcnc.domain.cross;

import lombok.Getter;

@Getter
public enum DomainCrossRegex {

	BCNC_DATE_TIME_FORMAT("uuuu-MM-dd-HH.mm.ss");

	private String regex;

	private DomainCrossRegex(String regex) {
		this.regex = regex;
	}
}
