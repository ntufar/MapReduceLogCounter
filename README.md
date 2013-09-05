Building
========

```
cd bin
jar -cvf ../MapReduceLogCounter.jar .
```

Running
=======

```
hadoop-1.2.1 % bin/hadoop jar MapReduceLogCounter.jar com.tufar.MapReduce.VarLogMessagesMapReduce /messages /msgCount
13/09/06 01:29:38 WARN mapred.JobClient: Use GenericOptionsParser for parsing the arguments. Applications should implement Tool for the same.
13/09/06 01:29:38 INFO util.NativeCodeLoader: Loaded the native-hadoop library
13/09/06 01:29:38 WARN snappy.LoadSnappy: Snappy native library not loaded
13/09/06 01:29:38 INFO mapred.FileInputFormat: Total input paths to process : 1
13/09/06 01:29:39 INFO mapred.JobClient: Running job: job_201309052204_0001
13/09/06 01:29:40 INFO mapred.JobClient:  map 0% reduce 0%
13/09/06 01:29:46 INFO mapred.JobClient:  map 100% reduce 0%
13/09/06 01:29:54 INFO mapred.JobClient:  map 100% reduce 33%
13/09/06 01:29:55 INFO mapred.JobClient:  map 100% reduce 100%
13/09/06 01:29:56 INFO mapred.JobClient: Job complete: job_201309052204_0001
13/09/06 01:29:56 INFO mapred.JobClient: Counters: 30
13/09/06 01:29:56 INFO mapred.JobClient:   Job Counters 
13/09/06 01:29:56 INFO mapred.JobClient:     Launched reduce tasks=1
13/09/06 01:29:56 INFO mapred.JobClient:     SLOTS_MILLIS_MAPS=9578
13/09/06 01:29:56 INFO mapred.JobClient:     Total time spent by all reduces waiting after reserving slots (ms)=0
13/09/06 01:29:56 INFO mapred.JobClient:     Total time spent by all maps waiting after reserving slots (ms)=0
13/09/06 01:29:56 INFO mapred.JobClient:     Launched map tasks=2
13/09/06 01:29:56 INFO mapred.JobClient:     Data-local map tasks=2
13/09/06 01:29:56 INFO mapred.JobClient:     SLOTS_MILLIS_REDUCES=8775
13/09/06 01:29:56 INFO mapred.JobClient:   File Input Format Counters 
13/09/06 01:29:56 INFO mapred.JobClient:     Bytes Read=7420249
13/09/06 01:29:56 INFO mapred.JobClient:   File Output Format Counters 
13/09/06 01:29:56 INFO mapred.JobClient:     Bytes Written=59322
13/09/06 01:29:56 INFO mapred.JobClient:   FileSystemCounters
13/09/06 01:29:56 INFO mapred.JobClient:     FILE_BYTES_READ=71348
13/09/06 01:29:56 INFO mapred.JobClient:     HDFS_BYTES_READ=7420415
13/09/06 01:29:56 INFO mapred.JobClient:     FILE_BYTES_WRITTEN=309827
13/09/06 01:29:56 INFO mapred.JobClient:     HDFS_BYTES_WRITTEN=59322
13/09/06 01:29:56 INFO mapred.JobClient:   Map-Reduce Framework
13/09/06 01:29:56 INFO mapred.JobClient:     Map output materialized bytes=71354
13/09/06 01:29:56 INFO mapred.JobClient:     Map input records=67742
13/09/06 01:29:56 INFO mapred.JobClient:     Reduce shuffle bytes=71354
13/09/06 01:29:56 INFO mapred.JobClient:     Spilled Records=5902
13/09/06 01:29:56 INFO mapred.JobClient:     Map output bytes=1069333
13/09/06 01:29:56 INFO mapred.JobClient:     Total committed heap usage (bytes)=408158208
13/09/06 01:29:56 INFO mapred.JobClient:     CPU time spent (ms)=5710
13/09/06 01:29:56 INFO mapred.JobClient:     Map input bytes=7418545
13/09/06 01:29:56 INFO mapred.JobClient:     SPLIT_RAW_BYTES=166
13/09/06 01:29:56 INFO mapred.JobClient:     Combine input records=67742
13/09/06 01:29:56 INFO mapred.JobClient:     Reduce input records=2951
13/09/06 01:29:56 INFO mapred.JobClient:     Reduce input groups=2920
13/09/06 01:29:56 INFO mapred.JobClient:     Combine output records=2951
13/09/06 01:29:56 INFO mapred.JobClient:     Physical memory (bytes) snapshot=509075456
13/09/06 01:29:56 INFO mapred.JobClient:     Reduce output records=2920
13/09/06 01:29:56 INFO mapred.JobClient:     Virtual memory (bytes) snapshot=2645078016
13/09/06 01:29:56 INFO mapred.JobClient:     Map output records=67742
hadoop-1.2.1 % 
```

Output
======

```
INADYN	71
NetworkManager	7414
Tor	835
accounts-daemon	11
alsactl	12
anaconda:	24
audispd:	101
auditctl	18
auditd	23
avahi-daemon	986
bgpd	1
blivet:	39
blueman-mechanism:	385
bluetoothd	1144
chronyd	144
dbus	1117
dbus-daemon	3061
dhclient	1065
dnsmasq	699
dnsmasq-dhcp	1497
firewalld:	8
fprintd	400
gnome-keyring-daemon	16
httpd	18
inadyn	124
kernel:	20790
laptop	17537
libvirtd	117
lightdm	10
lvm	8
mcelog	9
modem-manager	269
mtp-probe:	68
ntfs-3g	30
ntop	22
obex-client	3
packaging:	3
polkitd	10
program:	159
pulseaudio	2277
rngd	27
rpcbind:	2
rsyslogd:	19
rtkit-daemon	1196
setroubleshoot:	1298
setsebool:	7
smartd	100
smbd	22
spice-vdagent	10
su:	81
system-config-network	24
systemd	1987
systemd-logind	159
systemd-sleep	110
udisksd	61
vmusr	10
xinetd	543
xinit	55
yum	1506

```
