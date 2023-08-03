# intro-java-frameworks

feel free to destory it on your own branch :) ty.

slides https://docs.google.com/presentation/d/1mrDjslx3v90SwDRfWaByqF-F1LbVc17p4khC5r5USGo/edit?usp=sharing

On BeanLoader.clas -> check if you need

```
this
Class<?> clazz = Class.forName(FilenameUtils.removeExtension(path.replace('/', '.')));
or
Class<?> clazz = Class.forName(FilenameUtils.removeExtension(path.replace('\\', '.')));
```

based on your OS.
