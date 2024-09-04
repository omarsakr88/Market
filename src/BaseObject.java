public class BaseObject {
    private Integer id;

   private static Integer counter = 0;
   public Integer getId() {
       return id;
   }


    public void assignNewId() {
        id = getNextId();
    }

    public static Integer getNextId() {
        counter++;
        return counter;
    }
}
