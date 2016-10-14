package example23.AttributeConverter;

import javax.persistence.AttributeConverter;

public class StatusAttributeConverter implements AttributeConverter<String , Integer>{

	public Integer convertToDatabaseColumn(String status) {
		try {
            return Integer.parseInt(status);    //如果是数字，则直接返回（这里可以遍历StatusEnum的value来进一步验证）
        } catch (NumberFormatException e) {
            for (StatusEnum type : StatusEnum.values()) {    //如果不是数字，则通过StatusEnum来找到描述对应的数字
                if (status.equals(type.getDescription())) {
                    return type.getValue();
                }
            }
        }
        throw new RuntimeException("Unknown StatusEnum: " + status);
	}

	public String convertToEntityAttribute(Integer value) {
		for (StatusEnum type : StatusEnum.values()) {    //将数字转换为描述
            if (value.equals(type.getValue())) {
                return type.getDescription();
            }
        }
        throw new RuntimeException("Unknown database value: " + value);
	}

}
