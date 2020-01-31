
/**
 * @author JiangHao
 * @date 2018/12/9
 * @describe
 */
public class PersonMain {
   public static void main (String... args){
       Person person=new Person("Jianghao",24);
       person.age=25;
       person.setName("Hehe");
       System.out.println(person.getName()+"---"+person.age);
       //person.setName(null);
   }
}
