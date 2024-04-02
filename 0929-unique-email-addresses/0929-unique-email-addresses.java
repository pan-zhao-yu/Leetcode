class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> uniqueEmails = new HashSet<>();
        for(String email : emails){
            String formatEmail = getFormatEmail(email);
            uniqueEmails.add(formatEmail);
        }
        return uniqueEmails.size();
    }
    private String getFormatEmail(String email){
        String[] separet = email.split("@");
        String local = separet[0];
        String domain = separet[1];
        local = local.replace(".", "");
        String[] localPlus = local.split("\\+");
        local = localPlus[0];
        return local + "@" + domain;
    }
}