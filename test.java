class test {

    public static void main(String[] args) throws Exception {
        String privateKey = "134fa95e1cfde003767f2f1bbf1af0d9c0bd31dcc04fa1fe0faf4eda375af0e7";
        PublicFromPrivate publicFromPrivate = new PublicFromPrivate();
        StringBuilder stringBuilder7 = publicFromPrivate.getPublicFromPrivate(privateKey);
        System.out.println(stringBuilder7.toString());
   }


}
