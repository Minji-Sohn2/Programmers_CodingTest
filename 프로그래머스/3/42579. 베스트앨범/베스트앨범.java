import java.util.*;
import java.util.stream.Collectors;

class Solution {
    
    static class Music {
        private int index;
        private String genre;
        private int play;
        
        public Music(int index, String genre, int play) {
            this.index = index;
            this.genre = genre;
            this.play = play;
        }
        
        public int getIndex() {
            return this.index;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        // 1. 재생수 높은 장르 <장르, 재생수>
        Map<String, Integer> hashmap = new HashMap<>();
        for(int i=0; i<genres.length; i++) {
            hashmap.put(genres[i], hashmap.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        // 재생수 순으로 정렬
        List<String> ordered_genre = new ArrayList<>(hashmap.keySet());
        ordered_genre.sort((o1, o2) -> hashmap.get(o2).compareTo(hashmap.get(o1)));
        
        // 2. 장르 내에서 가장 많이 재생된 노래
        // 모든 정보 -> Music 객체로
        List<Music> musicList = new ArrayList<>();
        
        for(int i=0; i<genres.length; i++) {
            musicList.add(new Music(i, genres[i], plays[i]));
        }
        Collections.sort(musicList, (o1, o2) -> o2.play - o1.play);
        
        // 장르별 2곡씩 선정
        List<Music> bestAlbum = new ArrayList<>();
       
        //----------------------------------------------------
        for(String genre : ordered_genre) {
            // 2곡씩 담을 list
            List<Music> list = new ArrayList<>();
            // for(int i=0; i<genres.length; i++) {
            for(int i=0; i<musicList.size(); i++) {
                if(genre.equals(musicList.get(i).genre) && list.size()<2) {
                    list.add(musicList.get(i));
                }
            }
            
            // list 속 Music(2개) 고유번호 기준 정렬
            Collections.sort(list,(o1, o2) -> o2.play - o1.play);
            for(int i=0; i<list.size(); i++) {
                bestAlbum.add(list.get(i));
            }
            // bestAlbum.addAll(list);
        }
        //----------------------------------------------------
        
//         for (String genre : ordered_genre) {
//             // 2곡씩 담을 list
//             List<Music> list = new ArrayList<>();
//             for (int i = 0; i < musicList.size(); i++) {
//                 if (genre.equals(musicList.get(i).genre)) {
//                     list.add(musicList.get(i));
//                 }
//             }
    
//             // list 속 Music(2개) 고유번호 기준 정렬
//              Collections.sort(list, (o1, o2) -> o2.play - o1.play);
    
//             bestAlbum.add(list.get(0));
//             if (list.size() > 1) {
//               bestAlbum.add(list.get(1));
//             }
//          }
        //----------------------------------------------------
        
        // 고유번호(index)만 추출
        int[] answer = bestAlbum.stream()
            .mapToInt(Music::getIndex)
            .toArray();
        
        return answer;
    }
}