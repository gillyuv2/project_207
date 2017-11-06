package TagManager;


import java.util.ArrayList;

public class TagManager {

    private static ArrayList<Tag> tagList;

    /**
     * Constructor for the TagManager.
     */
    public TagManager() {
    }

    /**
     * Adds the tag in tagList if the tag doesn't exist in the tagList otherwise throws an exception.
     * @param tag A new tag to be added to tagList.
     */
    public void addTag(Tag tag) {
        if (!this.containsTag(tag) && tag.validTag()) {
                tagList.add(tag);
        } else {
            //todo throw exception
            System.out.println("Tag already exists in the list.");
        }

    }

    /**
     * Removes the given tag from the tagList or throws an exception that the tag doesn't exist.
     */
    public void removeTag(Tag tag) {
        if (this.containsTag(tag)) {
            tagList.remove(tag);
        } else {
            //todo throw exception
            System.out.println("Tag doesn't exists in the list.");
        }

    }

    /**
     * Renames the given tag with the new tag name.
     * @param tag Tag to be renamed.
     * @param newRepresentation New representation of the tag.
     */
    public void renameTag(Tag tag, String newRepresentation){
        if (this.containsTag(tag)){
            tag.setRepresentation(newRepresentation);
        }
    }

    /**
     * Checks if the tagList contains the given tag or not.
     * @param tag A tag to be checked.
     */
    private boolean containsTag(Tag tag){
        for (Tag t : tagList) {
            if (tag.equals((Tag) tag)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the list of all the tags in the system.
     * @return this.tagList
     */
    public static ArrayList<Tag> getTagList() {
        return tagList;
    }

    /**
     * Returns the String representation of the tagList.
     * @return
     */
    public String toString(){
        if (tagList.size() == 0){

            return "The tag manager is empty.";
        }else{
            StringBuilder tags = new StringBuilder();
            for (Tag f: tagList){
                tags.append(f.toString()).append("\n");
            }
            String tags2 = (String) tags;
            return tags2;
        }
    }
}
