package hello.ddd.domain;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

// AttributeConverter 인터페이스를 구현한 구현체에 해당 애노테이션을 달아준다. autoApply 를 true 로 선언하면,
// 어떠한 모델에서 Money 가 나타나면 이 Converter 를 자동으로 적용한다는 의미이다.
// autoApply 를 false 로 지정하면, Money 필드에 직접 @Convert(MoneyAttribute.class) 를 지정해줘야 한다.(Order 참조)
@Converter(autoApply = true)
public class MoneyAttributeConverter implements AttributeConverter<Money, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Money attribute) { // 객체 필드 값을 DB 칼럼 값으로 변환
        return attribute != null ? attribute.getValue() : null; // Money 가 null 이면 0 으로 DB 값 처리
    }

    @Override
    public Money convertToEntityAttribute(Integer dbData) { // DB 칼럼 값을 객체 필드 값으로 변환
        return dbData != null ? new Money(dbData) : null;
    }
}
