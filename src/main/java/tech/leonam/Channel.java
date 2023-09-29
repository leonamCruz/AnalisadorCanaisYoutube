package tech.leonam;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Channel implements Comparable<Channel>{
    private String name;
    private String subscribers;
    private String url;

    @Override
    public int compareTo(Channel o) {
        var subscriberOne = Long.parseLong(this.subscribers);
        var subscriberTwo = Long.parseLong(o.getSubscribers());

        return Long.compare(subscriberTwo, subscriberOne);
    }
}
