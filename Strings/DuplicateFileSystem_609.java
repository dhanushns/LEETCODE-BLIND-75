package BLIND_75.STRINGS;

import java.util.*;

public class DuplicateFileSystem_609 {

    public static void findDuplicatePaths(String[] paths){

        HashMap<String,List<String>> root = new HashMap<>();
        for(String path : paths){
            String[] arr = path.split(" ");
            String dir = arr[0];

            for(int i = 1; i < arr.length; i++){
                String fileName = arr[i].substring(0,arr[i].indexOf("("));
                String content = arr[i].substring(arr[i].indexOf("(")+1,arr[i].length()-1);

                String filePath = dir+"/"+fileName;
                if(root.containsKey(content)){
                    List<String> existingPath = root.get(content);
                    existingPath.add(filePath);
                    root.put(content,existingPath);
                }
                else{
                    root.put(content,new ArrayList<>(List.of(filePath)));
                }
            }
        }
        List<List<String>> duplicates = new ArrayList<>();
        for(String content : root.keySet()){
            if(root.get(content).size() > 1){
                List<String> dir = new ArrayList<>();
                for(String path : root.get(content)){
                    dir.add(path);
                }
                duplicates.add(dir);
            }
        }
        System.out.println(duplicates);
    }

    public static void main(String[] args) {

        String[] paths = {"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)"};
        findDuplicatePaths(paths);

    }

}
