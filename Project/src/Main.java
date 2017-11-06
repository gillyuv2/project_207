
import TagManager.Tag;
public class Main{

    public static void main(String[] args){

        Tag tag1 = new Tag("Yuri");
        tag1.saveTimeStamp();
        System.out.println(tag1.getTag());
        System.out.println(tag1.getTimeStamp());

    }
}
