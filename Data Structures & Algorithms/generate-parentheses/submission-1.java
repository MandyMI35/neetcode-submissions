class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(n, 0, 0, new StringBuilder(""));
        return res;
    }
    public void dfs(int n, int o, int c, StringBuilder sb) {
        if (o == n) {
            int added=0;
            while (c != n) {
                sb.append(')');
                c++;added++;
            }
            res.add(sb.toString());
            sb.delete(sb.length() - added, sb.length());
            return;
        }
        sb.append('(');
        dfs(n, o + 1, c, sb);
        sb.deleteCharAt(sb.length() - 1);
        if (c< o) {
            sb.append(')');
            dfs(n, o, c+1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
