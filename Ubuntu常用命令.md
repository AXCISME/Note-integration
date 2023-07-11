1. 查找端口占用和杀死进程

   #查找端口运行的进程
   netstat -alnp | grep  "端口"
   #结束进程
   kill -9 pid

2. 查看实时网速

   sudo apt install ifstat

   ifstat

3. 线程运行诊断

   - top:定位哪个进程对cpu占用过高
   - ps H -eo pid,tid,%cpu | grep 进程id
   - jstack 进程id