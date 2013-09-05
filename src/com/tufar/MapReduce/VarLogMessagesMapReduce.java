package com.tufar.MapReduce;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;




public class VarLogMessagesMapReduce extends MapReduceBase {


	public static class VarLogMessagesMap extends MapReduceBase implements
			Mapper<LongWritable, Text, Text, IntWritable> {

		private final static IntWritable one = new IntWritable(1);
		private Text word = new Text();

		/**
		 * Parses strings in /var/log/messages format and extracts the count of the facility that logged the line. Example:
<pre>
Sep  1 18:01:58 laptop kernel: [    0.689118] pci_bus 0000:00: root bus resource [mem 0xafa00000-0xfeafffff]
Sep  1 18:01:58 laptop kernel: [    0.692439] pci 0000:00:14.0: System wakeup disabled by ACPI
Sep  1 18:01:58 laptop kernel: [    0.695449] pci 0000:00:1a.0: System wakeup disabled by ACPI
Sep  1 18:01:58 laptop kernel: [    0.695624] pci 0000:00:1b.0: System wakeup disabled by ACPI
Sep  1 18:01:58 laptop kernel: [    0.695765] pci 0000:00:1c.0: System wakeup disabled by ACPI
Sep  1 18:01:58 laptop kernel: [    0.695905] pci 0000:00:1c.1: System wakeup disabled by ACPI
Sep  1 18:01:58 laptop kernel: [    0.696045] pci 0000:00:1c.2: System wakeup disabled by ACPI
Sep  1 18:01:58 laptop kernel: [    0.698461] pci 0000:00:1d.0: System wakeup disabled by ACPI
</pre>
	 		we will take the field number 5, in our case: "kernel"
		 * 
		 */
		@Override
		public void map(LongWritable key, Text values,
				OutputCollector<Text, IntWritable> output, Reporter reporter)
				throws IOException {
			String line = values.toString();
			if(line == null)
				return;
			String[] parts = line.split(" ");
			if(parts.length < 5)
				return;
			String w = parts[4];
			int x = w.indexOf('['); 
			if(x != -1)
				w = w.substring(0,x);
			word.set(w);
			output.collect(word, one);
		}
	}
	
	public static class VarLogMessagesReduce extends MapReduceBase implements
			Reducer<Text, IntWritable, Text, IntWritable> {
		public void reduce(Text key, Iterator<IntWritable> values,
				OutputCollector<Text, IntWritable> output, Reporter reporter)
				throws IOException {
			int sum = 0;
			while (values.hasNext()) {
				sum += values.next().get();
			}
			output.collect(key, new IntWritable(sum));
		}
	}	
	
	public static void main(String[] args) throws Exception {
		JobConf conf = new JobConf(VarLogMessagesMapReduce.class);
		conf.setJobName("wordcount");

		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(IntWritable.class);

		conf.setMapperClass(VarLogMessagesMap.class);
		conf.setCombinerClass(VarLogMessagesReduce.class);
		conf.setReducerClass(VarLogMessagesReduce.class);

		conf.setInputFormat(TextInputFormat.class);
		conf.setOutputFormat(TextOutputFormat.class);

		FileInputFormat.setInputPaths(conf, new Path(args[0]));
		FileOutputFormat.setOutputPath(conf, new Path(args[1]));

		JobClient.runJob(conf);
	}	
	
}
