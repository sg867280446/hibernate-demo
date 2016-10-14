package example23.AttributeConverter;

public enum StatusEnum {
    ENABLE(1,"∆Ù”√");
	
	private final Integer value;
	private final String description;
	
	StatusEnum(Integer value,String description){
		this.value = value;
		this.description = description;
	}

	public Integer getValue() {
		return value;
	}

	public String getDescription() {
		return description;
	}
	
	
}
