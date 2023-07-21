package hello.ddd.event.basic.common.event;

/**
 * Event 는 기본적으로 아래 3가지 요소가 포함되어야 한다.
 *  1. 어떤 이벤트인가? : 이벤트의 종류를 표현할 수 있어야 하며, 보통 class 명으로 유추할 수 있게 class 명을 짓는다.
 *  2. 발생시간 : 이벤트가 발생할 시간을 가진다.
 *  3. 추가 데이터 : 이벤트는 크게 1) 후처리용 과 2) 데이터 동기화용 으로 사용되는데, 이 때 사용되어야 하는 데이터가 있다면, 데이터를 가져야 한다.
 */
public abstract class Event {
    private final long timestamp;

    public Event() {
        this.timestamp = System.currentTimeMillis();
    }

    public long getTimestamp() {
        return timestamp;
    }
}
