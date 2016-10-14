package example23.AttributeConverter;

import javax.persistence.AttributeConverter;

public class StatusAttributeConverter implements AttributeConverter<String , Integer>{

	public Integer convertToDatabaseColumn(String status) {
		try {
            return Integer.parseInt(status);    //��������֣���ֱ�ӷ��أ�������Ա���StatusEnum��value����һ����֤��
        } catch (NumberFormatException e) {
            for (StatusEnum type : StatusEnum.values()) {    //����������֣���ͨ��StatusEnum���ҵ�������Ӧ������
                if (status.equals(type.getDescription())) {
                    return type.getValue();
                }
            }
        }
        throw new RuntimeException("Unknown StatusEnum: " + status);
	}

	public String convertToEntityAttribute(Integer value) {
		for (StatusEnum type : StatusEnum.values()) {    //������ת��Ϊ����
            if (value.equals(type.getValue())) {
                return type.getDescription();
            }
        }
        throw new RuntimeException("Unknown database value: " + value);
	}

}
