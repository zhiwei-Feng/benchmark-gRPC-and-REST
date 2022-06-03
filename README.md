# Benchmark-gRPC-and-REST

A simple benchmarking between gRPC and REST using SpringBoot

## Prepare
模仿实际使用过程在SpringBoot controller中分别调用gRPC和Rest api的场景,具体来说调用user api获取指定id的用户信息并返回

**Configuration**
- server-side configuration见module `minimall-user`中的配置文件`application.properties`
- client-side configuration见module `demo`
- grpc相关文件(proto和生成文件)见module `grpc-base`

## Results
- 压测工具: https://github.com/codesenberg/bombardier
- os: https://app.warp.dev/block/sJIsl6KGG8wY9CrgWzvwKD

Raw Results: 
- [200 thread](https://app.warp.dev/block/o3Mr6StstwFpJOfebHIgXb)
- [300 thread](https://app.warp.dev/block/GK2iV9yvvVg6DHzrS1Ip3b)

| Name  | Thread-Num | Total-Req-Num | Throughput(Avg.) | Improvemnt |
|-------|------------|---------------|------------------|------------|
| REST1 | 200        | 5000          | 5.22MB/s         | -          |
| gRPC1 | 200        | 5000          | 6.59MB/s         | 1.26x      |
| REST2 | 300        | 5000          | 6.66MB/s         |  -         |
| gRPC2 | 300        | 5000          | 7.31MB/s         | 1.1x       |