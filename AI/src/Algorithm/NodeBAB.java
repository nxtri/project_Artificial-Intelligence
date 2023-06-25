
package Algorithm;

/**
 *
 * @author Đ.Tee
 */
public class NodeBAB {
    
    public NodeBAB parent;
    private int cost;
    private int[][] distances;
    private int[] remaining;
    public int index;

    /**
     * Constructor: Tạo node
     * 
     * @param parent : Node cha của node hiện tại
     * @param cost : Chi phí giữa 2 node (node hiện tại và node cha)
     * @param distances : Ma trận 2d chứa khoảng cách giữa 2 điểm
     * @param remaining : Chứa các điểm còn lại
     * @param index : Vị trí của node hiện tại
     */
    public NodeBAB(NodeBAB parent, int cost, int[][] distances, int[] remaining, int index) {
        this.parent = parent;
        this.cost = cost;
        this.distances = distances;
        this.remaining = remaining;
        this.index = index;
    }

    /**
     * Constructor default
     */
    public NodeBAB() {
    }
    
    /**
     * Kiểm tra có phải node cuối (length = 1) hay không?
     * 
     * @return true - node cuối, false - không p
     */
    public boolean isTerminal()
    {
        return remaining.length == 1;
    }
    
    /**
     * Khởi tạo các node con của node hiện tại từ remaining
     * 
     * @return danh sách node con
     */
    public NodeBAB[] generateChildren() {
        NodeBAB[] children = new NodeBAB[remaining.length - 1];
        int newRemaining[] = new int[remaining.length - 1]; //Lưu các điểm khác điểm hiện tại
        int i = 0;
        
        //Thêm các điểm vào newRemaining, bỏ qua điểm hiện tại
        for(int pos : remaining)
        {
            if(pos == index) continue;
            newRemaining[i++] = pos;
        }
        
        //Khởi tạo các node children
        for(int j = 0; j < children.length; j++)
        {                    
            children[j] = new NodeBAB(this, distances[index][newRemaining[j]], distances, newRemaining, newRemaining[j]);
        }
        
        return children;
    }
    
    /**
     * Tìm lower bound của node hiện tại
     * Sử dụng lower bound cost (<=> cận dưới or lớn nhất bé hơn) để loại bỏ các đường dẫn có chi phí cao hơn đường dẫn hiện tại
     * 
     * @return chi phí
     */
    public int getLowerBound()
    {
        int costs = 0;
        
        if(remaining.length == 2) return getPathCost() + distances[remaining[0]][remaining[1]];
        
        for(int i : remaining)
        {
            int low1 = Integer.MAX_VALUE;
            int low2 = Integer.MAX_VALUE;
            
            for(int j : remaining)
            {
                if(j == i) continue;
                
                int value = distances[i][j];
                if(value < low1)
                {
                    low2 = low1;
                    low1 = value;
                }
                else if(value < low2)
                {
                    low2 = value;
                }
            }
            
            costs += low1 + low2;
        }
        
        return costs/2 + getParentCost();
    }
    
    /**
     * Tính tổng chi phí của toàn bộ đường đi tới vị trí index
     * @return chi phí
     */
    public int getPathCost()
    {
        return distances[0][index] + getParentCost();
    }
    
    /**
     * Tính chí phí của parent tại vị trí index
     * @return chi phí
     */
    public int getParentCost()
    {
        if(parent == null) return 0;
        else return cost + parent.getParentCost();
    }
    
    /**
     * Tìm tuyến đường đến điểm hiện tại
     * 
     * @return tuyến đường
     */
    public int[] getPath()
    {
        //Độ sâu của index
        int depth = distances.length - remaining.length + 1;
        
        int path[] = new int[depth];
        getPathInIndex(path, depth - 1);
        
        return path;
    }
    
    /**
     * Đệ quy tìm tuyến đường tới vị trí i
     * @param path : Lưu tuyến đường
     * @param i : vị trí của node
     */
    public void getPathInIndex(int[] path, int i)
    {
        path[i] = index;
        if(parent != null) parent.getPathInIndex(path, i - 1);
    }
    
    
}
