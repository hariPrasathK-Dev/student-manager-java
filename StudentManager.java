import java.util.Arrays;
import java.util.Scanner ;
import java.util.ArrayList;

class Student
{
    Scanner scanner = new Scanner(System.in) ;
    int Id ;
    String Name ;
    int [] marks ;

    public Student addStudent()
    {
        System.out.println("Enter Student ID");
        Id = scanner.nextInt();
        System.out.println("Enter Student Name");
        scanner.nextLine() ;
        Name = scanner.nextLine() ;
        System.out.println("Enter the six subject marks(Separated by Space) : ") ;
        String [] str = scanner.nextLine().trim().split(" ") ;
        marks = new int[str.length] ;
        for(int i=0;i<str.length;i++)
        {
            marks[i] = Integer.parseInt(str[i]) ;
        }

        return this ;
    }

    @Override
    public String toString() {
        return "Id: " + this.Id + "\n"
                + "Name: " + this.Name + "\n"
                + "Marks: " + Arrays.toString(this.marks);
    }


}

public class StudentManager
{
    public static void main(String [] args)
    {
        int choice ;
        ArrayList<Student> students = new ArrayList<>() ;
        Scanner scanner = new Scanner(System.in) ;
        do
        {
            System.out.println("------------------------------------------------------------") ;
            System.out.println("Operations Possible for the Student Records :");
            System.out.println("1. Add Student");
            System.out.println("2. View Students") ;
            System.out.println("3. Update Student Details") ;
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.println("------------------------------------------------------------") ;

            System.out.println("Enter your choice : ") ;

            if(scanner.hasNextInt())
            {
                choice = scanner.nextInt() ;

                if(choice >=1 && choice <=5)
                {
                    switch (choice)
                    {
                        case 1 :
                        {
                            students.add(new Student().addStudent()) ;
                            break ;
                        }

                        case 2 :
                        {


                            for (int i = 0; i < students.size(); i++)
                            {
                                System.out.println("Student "+(i+1)+" Details : ") ;
                                System.out.println(students.get(i)) ;
                                System.out.println() ;
                            }

                            break ;
                        }

                        case 3 :
                        {
                            System.out.println("Enter Student ID : ") ;
                            int id = scanner.nextInt() ;

                            for (int i = 0; i < students.size();)
                            {
                                if(students.get(i).Id == id)
                                {
                                    System.out.println("what do you want to change ?") ;
                                    System.out.println("1) Id") ;
                                    System.out.println("2) Name") ;
                                    System.out.println("3) marks") ;
                                    System.out.println("Enter your choice :") ;
                                    int update_choice = scanner.nextInt() ;
                                    if(update_choice == 1)
                                    {
                                        System.out.println("Enter the new Id for this student : ") ;
                                        int update_id = scanner.nextInt() ;
                                        students.get(i).Id = update_id ;
                                        i++ ;
                                        break ;
                                    }
                                    else if(update_choice ==2)
                                    {
                                        System.out.println("Enter the Name to be updated : ") ;
                                        scanner.nextLine() ;
                                        String update_name = scanner.nextLine() ;
                                        students.get(i).Name = update_name ;
                                        i++ ;
                                        break ;
                                    }
                                    else if(update_choice ==3)
                                    {
                                        System.out.println("Enter all the six subject marks of the student : ");

                                        String [] str = scanner.nextLine().trim().split(" ") ;
                                        for(int j=0;j<str.length;j++)
                                        {
                                            students.get(i).marks[j] = Integer.parseInt(str[j]) ;
                                        }
                                        i++ ;
                                        break ;
                                    }
                                    else
                                    {
                                        System.err.println("Please enter a valid choice") ;

                                    }
                                }
                                else
                                {
                                    System.err.println("Student with the specified Id doesn;t exist") ;
                                    i++ ;
                                }
                            }

                            break ;
                        }

                        default:
                        {
                            System.out.println("Enter Student ID who needs to be removed : ") ;
                            int remove_id = scanner.nextInt() ;

                            for (int j = 0; j < students.size(); j++)
                            {
                                if(students.get(j).Id == remove_id)
                                {
                                    students.remove(j) ;
                                }
                                j++ ;
                            }
                            break ;
                        }

                    }
                }
                else
                {
                    System.err.println("Please enter a valid choice") ;
                }
            }
            else
            {
                choice = 0 ; //Default to return back to the menu.
                System.err.println("Please enter a valid choice(Must be an Integer)") ;
            }


        }while(choice != 5) ;
    }
}
