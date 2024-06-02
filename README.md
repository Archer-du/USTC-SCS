# USTC-SCS

---
## 项目信息

- MySQL DBMS(community server) 版本：8.0.37
> 在统一使用IDEA作为IDE的情况下，除了MySQL意外我也不清楚还有什么其他环境可能不统一。建议大家clone到本地自己build一下看有没有问题。

## 开发规范

1. 在github上fork此仓库
2. 将fork的仓库克隆到本地
3. 在本地将此远程仓库添加为远端，命名为upstream
  > 此时你的本地应该有两个远端，分别为origin和upstream
4. 在本地进行分支规范的开发
5. 完成开发后推送到相应远程分支，并在github上从fork的仓库向该主仓库提交pull request，完成远端的合并

为了方便，我们将舍弃一些分支开发规范性，仅需在develop分支上开发新功能，在fix分支上维护和修复，并在完成开发并测试稳定后通过pull request合并到master分支作为新的稳定版本即可即可。

## 实用工具

- [scene builder](https://openjfx.cn/scene-builder/)
