package main.PriorityQueue;
public class ExamQueue{
    private HeapPacient queue;
    private int numPriority0 = 0;
    private int numPriority1 = 0;
    private int numPriority2 = 0;
    private int numPriority3 = 0;

    public ExamQueue(){
        this.queue = new HeapPacient(new Pacient[]{});
    }

    public void add(String name, int priority) throws Exception{
        Pacient p;
        switch (priority) {
            case 0:
                p = new Pacient(numPriority0, name, priority);
                numPriority0++;                
                break;
            case 1:
                p = new Pacient(numPriority1, name, priority);
                numPriority1++;                
                break;
            case 2:
                p = new Pacient(numPriority2, name, priority);
                numPriority2++;
                break;
            case 3:
                p = new Pacient(numPriority3, name, priority);
                numPriority3++;
                break;
        
            default:
                throw new Exception("Invalid priority");
        }

        this.queue.append(p);
    }

    public Pacient pop(){
        return this.queue.pop();
    }

    public String toString(){
        return this.queue.toString();
    }
}