import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

public class WixChallanges {
    public static int BuildingChallange(String s){
        int floor = 0;
        for(int i = 0 ; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                floor++;
            } else if (s.charAt(i) == ')') {
                floor--;
            }else{
                System.out.println("Error");
            }
        }
        return floor;
    }

    public static List isListInListOfLists(List<List> listOfLists, List<Integer> list){
        for(List iterator : listOfLists){
            if (iterator.get(0) == list.get(0) && iterator.get(1) == list.get(1)){
                return iterator;
            }
        }
        return null;
    }

    public static int PositionCountChallange(String s){
        char right = '>', left = '<', up = '^', down = 'v';
        int x = 0, y = 0,positionCount = 0;
        ArrayList<List> listOfPints = new ArrayList<>();
        listOfPints.add(new ArrayList(ImmutableList.of(x,y,1)));
        for (int i = 0; i < s.length(); i++){
            if(s.charAt(i) == left){
                x--;
                ModifyListOfLists(x, y, listOfPints);
            }else if(s.charAt(i) == right){
                x++;
                ModifyListOfLists(x, y, listOfPints);
            }else if(s.charAt(i) == up){
                y++;
                ModifyListOfLists(x, y, listOfPints);
            }else if(s.charAt(i) == down){
                y--;
                ModifyListOfLists(x, y, listOfPints);
            }else{
                System.out.println("Error");
            }
        }
        for (List list : listOfPints){
            System.out.println("X:" + list.get(0) + " Y:" + list.get(1) + " numOfVisitations:" + list.get(2));
            if ((Integer)list.get(2) > 1){
                System.out.println("PositionCountUpdated");
                positionCount++;
            }
        }
        return positionCount;
    }

    private static void ModifyListOfLists(int x, int y, ArrayList<List> listOfPints) {
        List listInListOfLists = isListInListOfLists(listOfPints, ImmutableList.of(x, y));
        if(listInListOfLists == null){
            listOfPints.add(new ArrayList(ImmutableList.of(x, y,1)));
        }else{
            Integer numOfVisitations = (Integer) listInListOfLists.get(2);
            listInListOfLists.set(2,numOfVisitations+1);
        }
    }

    public static void main(String[] args){
        String s = "v<<<>><^v^<>><v^<^v>v><v<<^>v<<v><v<<^v>^^v>>>vvvv<^<v><vv^vvv^><vv^v><><<^v><^v>v<><<<<<>^<^<v^^^vv^v><^<v<<<>^^v^vv<>v^v^>^v^v>^^>^<v^v<>^<v>^v><<>v<>v^v<^<v<^<>>v>vv<>>^^<^<<v^^<^<<^<^<^<vvv>v^v<>v<vv>^>>vv>vv^>v^<v><>>^^<<<<v<^^v<v<^<><><>^v^^^^>^>^vv^><^^^v^^v>vv^vvvv^v<^><<v<^<<^v<>^<^><v^^<^>>^^<>v>><^^vv<^<^<^<^>><vv^v><^<^><<^^^>^<v>^><^vvv^^<v<><<v<v^^v^^v^<^^^><^<v<v^<>>>v^>><^<^^<<v>><^>v<v<<><>>^<>^vv>v^^v<<>>>v<>><<^v<>^^v^vvv<<><>>^>><v<<v^<<>>>v^vv<v<>v<>v>^<<^v^>v<vvv><^v<<<vv<<<^^^<^<v>v><<<>^^vv^>^>^v>><><^>>>v<v<<<<<vv^><v^<<v^>><^>><vv^>>v^>>v>v<vv<v><<v<><>^vv>^<^^v^<^^>^v>><^v>^>^v<<v>^><>^>>^^><v<>>>v><^^v<^>^><^>><v^><vv>>>v>^^^vv>^^^>>><<><<<^v><<^v^^v><^v>>v>^v<<^<<^<>><vv^^^<vv<<^vv<^>^^vv<v<<>^<<v^><^^<>^><^^><<v>><<<<>v>v>><^^<v<^<^^^<><><v><v^v><^<^>>^^v<>^^>vv<^v<vv<^v<v<^<^>^vv^<^>vv>>>v<v^<^^^^vv>v>^^<<<^<>><>>>^v<>v^^>^v<^^vvv<<>v>><^v><>vv><^^><<^v^>>^>^v^^><<<^^>vv<><><>>^<v>v>>^<>^>v^^v<>vv<vv^<<v<^v<>v^v^v^v>v^^^^vvv>^^v<<>>>>>>vvv^<<^v<vv^v^><>v^^vv^^v<>v>>^^^^^^<>vv<v^v><v<<<>^v<>>v><v>>>^<>^^v<<^^><^vv<<vv<vvv<^vv^v>v^^^><<v<v>v^^v<vv>v^>><^v^v<>^^<<^<^v^<vvv<<vv>vv>>>v<<<<v^^vvv^^<^^<><v<>v^v<<<^<>>^>^v>^vv<>v^^^v^<^^v<^<><vv<<><>v<>v<v<v>^<v<v^>vvv^>^><>^^^>vvv^^>^<<^vv<>v<^>^<><<<v^^<vv<<>^<<v^>^>^vv>vvv^<<v<>^^<>^^v<<<^<<^<<><<<^v^><>>vv<vvv<<^>v>>^^^vv>^<v><><^v^^^<vv>^>>v<^v<<<vv>>^^><v>^v^^<^<^<>^^<<^><<><^>v<v^><^<v>^vv>v>v<<<<>^^<>^^>>>vv>^>>>v<>^>vv<<<^>><><<>v><^<<^^^^v<^<^v<>^<<^><>^<>v><<v><v<>vvv>>vv^<^v<vv><^>^<^^<^v>v>^>>v><<<><v^><^^>v<><^<v^^>>>^<>v^^v<^^v^v><<vvv>^v><v<v><>><<^><>v<>^>>v><^v^>^>^><>^vv>>v<>^><<v^v>^v<v^<<>><v^vv>>^>^v>^v^>^vv<v>^<>>><<v^^><>><v>><vv^>>v<vvv^^>v<>><^^v^^<^^>v<<<v^v<<<<>^^><<<>><<v>><><v><<>>v>v<v>v^<v<>>v<^^^>^v>v^v><<<vvv^vvv^>vv<><<>^^><><<>v<><^>vv^v<<><<^vv^vv<v>v^^v>><<^>v<v^>><vvvvvv<^<vvvv>>>>v^vv<<>><<<v>^>vv>^^>^^^^>vvv>><v^v<^<^<<>><v>vv^<v^>^<v^^^>vvv^>v^>^<^v>^>v^<^<v<<^<^<>><<v^<v>^<^<v>v^^v^^^v^^<>^>>v^^v<<<^^>^>v<^>^<>>v^^<<vv<v<v^><v^^";
        System.out.println(PositionCountChallange(s));
    }
}
