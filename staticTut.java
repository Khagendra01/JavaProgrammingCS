// Online Java Compiler
// Use this editor to write, compile and run your Java code online
class StClass {
        
        public static int x = 5;
        
        public StClass(){
            
        }
        
        public void foo(){
            System.out.println("foo");
        }
}


class NewClass {
        
        public int x = 10;
        
        public NewClass(){
            StClass n = new StClass();
            n.x = 9;
            System.out.println(StClass.x + x);
        }
}
    
class HelloWorld {
    
    public static void main(String[] args) {
        
        NewClass n = new NewClass();
        
    }
}
