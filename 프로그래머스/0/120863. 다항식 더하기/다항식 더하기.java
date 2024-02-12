class Solution {
    public String solution(String polynomial) {
        int yesX=0;
        int noX=0;
        
        for (String s : polynomial.split(" ")) {
            if (s.contains("x")) {
                yesX += s.equals("x") ? 1 : Integer.parseInt(s.replaceAll("x", ""));
            } else if (!s.equals("+")) {
                noX += Integer.parseInt(s);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        return makeExpression(yesX, noX);
    }
    
    private String makeExpression(int yesX, int noX) {
        String xPart = (yesX != 0) ? (yesX > 1 ? yesX + "x" : "x") : "";
        String numPart = (noX != 0) ? ((yesX != 0) ? " + " +noX : String.valueOf(noX)) : (yesX == 0 ? "0" : "");

        return xPart + numPart;
    }
}