package TagManager;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Tag {

    private String representation;
    private String tagRepresentation;
    private static String timeStamp;

    /**
     * Constructor for the Tag class.
     */
    public Tag() {
    }

    /**
     * Sets the given string as Tag representation.
     * @param rep A string to be tagged.
     */
    public void setRepresentation(String rep){
        this.representation = rep;
        this.tagRepresentation = "@" + this.representation;
    }


    /**
     * Returns the string tag representation of the Tag with '@' sign added to its front.
     * @return Tag representation
     */
    public String getTag(){
        return this.tagRepresentation;
    }

    /**
     * Sets the timestamp when a tag is created.
     */
    public void saveTimeStamp(){
        String newTimeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        timeStamp = newTimeStamp;
    }

    /**
     * Returns the String representation of the time stamp of the Tag.
     *
     * @return timestamp Time stamp of a given tag.
     */
    public String getTimeStamp(){
        return timeStamp;
    }

    /**
     * Returns the string representation of the tag to print.
     * @return String representation of the Tag.
     */
    public String toString(){
        return "Tag:" + getTag() + "Created at : " + timeStamp;
    }

    /**
     * Returns true if the two tags are equal
     * @param otherTag Other tag to compare with.
     * @return boolean
     */
    public boolean equals(Tag otherTag){
        return this.representation.equals((String) otherTag.representation)
                && timeStamp.equals((String) otherTag.getTimeStamp());
    }

    /**
     * Returns true if the tag has a valid tag format or false if the tag is not in the valid format.
     */
    public boolean validTag(){
        return ! this.representation.contains("@") && !this.representation.contains(" ");
    } //todo
      // 1. Improve the tag specifications.
     // 2. Just in case of an empty tag.
}
