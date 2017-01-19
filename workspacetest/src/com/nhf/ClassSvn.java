package com.nhf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ClassSvn
{
    static int count = 0;
    
    private static String baseJavaPath = "H:/different/src/main";
    
    private static String javaPath = baseJavaPath + "/java";
    
    private static String propertyPaht = baseJavaPath + "/resources";
    
    private static String targetPath = "H:/different/tomcat/classes";
    
    private static String classPath = "F:/portalone/code/decoupling/game.productline/iPublicLine/target/classes";
    
    public static void main(String[] args)
        throws Exception
    {
        File f1 = new File(javaPath);
        File f2 = new File(classPath);
        if (f1.exists() && f2.exists())
        {
            createPath(f1);
        }
        
        File f3 = new File(propertyPaht);
        if (f3.exists() && f2.exists())
        {
            createPath(f3);
        }
        System.out.println("共复制了" + count + "个class文件");
    }
    
    /**
     * 
     *  根据java文件找到对应的class文件，并将class文件复制到对应目录下，同时删除java文件
     
     * <一句话功能简述>
     * <功能详细描述>
     * @param sourceFilePath  源文件路径 ，H:\\different\\src\\main\\java
     * @throws Exception 
     * @see [类、类#方法、类#成员]
     */
    public static void createPath(File sourceFilePath)
        throws Exception
    {
        //如果源文件的路径存在
        if (sourceFilePath.exists())
        {
            File[] files = sourceFilePath.listFiles();
            for (File sourceJavaFile : files)
            {
                if (sourceJavaFile.isDirectory())
                {//判断是否是目录，如果是目录，则进入目录中
                    createPath(sourceJavaFile);
                }
                else if (sourceJavaFile.getName().endsWith(".java")) //如果是java文件
                {
                    //去掉扩展名之后的文件名
                    final String fileNameWithoutSuffix =
                        sourceJavaFile.getName().substring(0, sourceJavaFile.getName().indexOf(".java"));
                        
                    //class 所在文件夹的路径。
                    final String classFilePath = classPath + sourceJavaFile.getPath().substring(javaPath.length(),
                        sourceJavaFile.getPath().lastIndexOf(File.separator) + 1);
                    File[] filels = new File(classFilePath).listFiles();//获取目标文件夹下的所有文件
                    for (int i = 0; i < filels.length; i++)
                    {
                        if (filels[i].isFile())
                        {
                            if (filels[i].getName().indexOf(fileNameWithoutSuffix) != -1) //将带$的class也copy出来
                            {
                                count++;
                                File classfile = new File(classFilePath + filels[i].getName());
                                
                                String midPath = sourceJavaFile.getPath().substring(javaPath.length(),
                                    sourceJavaFile.getPath().lastIndexOf(File.separator) + 1);
                                    
                                File javaDir = new File(targetPath + midPath);
                                if (!javaDir.exists())
                                {
                                    javaDir.mkdirs();
                                }
                                File javafile = new File(javaDir, filels[i].getName());
                                
                                try
                                {
                                    copyFile(classfile, javafile);
                                    //sourceJavaFile.delete();
                                }
                                catch (Exception e)
                                {
                                    e.printStackTrace();
                                }
                                System.out.println(filels[i].getName());
                            }
                        }
                    }
                }
                else if (sourceJavaFile.getName().indexOf(".xml") != -1
                    || sourceJavaFile.getName().indexOf(".properties") != -1)
                { //如果是对应的配置文件，则直接拷贝这个配置文件到目标路径中。
                    
                    //1、构造需要拷贝的目标文件的配置文件路径。
                    String midPath = sourceJavaFile.getPath().substring(propertyPaht.length(),
                        sourceJavaFile.getPath().lastIndexOf(File.separator) + 1);
                    String destPath = targetPath + midPath;
                    
                    File destDir = new File(destPath);
                    if (!destDir.exists())
                    {
                        destDir.mkdirs();
                    }
                    String destFileName = destPath + sourceJavaFile.getName();
                    
                    String sourceClassFile = classPath + midPath + sourceJavaFile.getName();
                    
                    File sFile = new File(sourceClassFile);
                    File dFile = new File(destFileName);
                    if (sFile.exists())
                    {
                        copyFile(sFile, dFile);
                        sourceJavaFile.delete();
                    }
                    
                }
            }
        }
    }
    
    /** 
     * 将F1复制到F2 
     * 
     */
    public static void copyFile(File inputFile, File outputFile)
        throws Exception
    {
        int length = 2097152;
        FileInputStream in = new FileInputStream(inputFile);
        FileOutputStream out = new FileOutputStream(outputFile);
        byte[] buffer = new byte[length];
        
        int len = 0;
        while ((len = in.read(buffer)) != -1)
        {
            out.write(buffer, 0, len);
        }
        in.close();
        out.flush();
        out.close();
    }
    
}
