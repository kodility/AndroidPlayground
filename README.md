# AndroidPlayground
Android Studio initial project template for new projects

## ktlint rules setup
> it makes Intellij IDEA's built-in formatter produce 100% ktlint-compatible 
 code. 

##### Option #1 (recommended)

> (inside project's root directory)  

```sh
ktlint applyToIDEAProject
# or if you want to be compliant with Android Kotlin Style Guide
ktlint --android applyToIDEAProject
```

##### Option #2

Apply to all IDEA projects:
```shell
$ ./ktlint applyToIDEA
```
Or if you want to use android specific code style:
```shell
$ ./ktlint --android applyToIDEA
```

##### Option #3

Go to <kbd>File</kbd> -> <kbd>Settings...</kbd> -> <kbd>Editor</kbd>
- <kbd>General</kbd> -> <kbd>Auto Import</kbd>
  - check `Optimize imports on the fly (for current project)`.
- <kbd>Code Style</kbd> -> <kbd>Kotlin</kbd>
  - <kbd>Set from...</kbd> -> <kbd>Predefined style</kbd> -> <kbd>Kotlin style guide</kbd> (Kotlin plugin 1.2.20+).
  - open <kbd>Code Generation</kbd> tab
    - uncheck `Line comment at first column`;
    - select `Add a space at comment start`.
  - open <kbd>Imports</kbd> tab
    - select `Use single name import` (all of them);
    - remove `import java.util.*` from `Packages to Use Import with '*'`.
  - open <kbd>Blank Lines</kbd> tab
    - change `Keep Maximum Blank Lines` / `In declarations` & `In code` to 1 and `Before '}'` to 0.
  - (optional but recommended) open <kbd>Wrapping and Braces</kbd> tab
    - uncheck `Method declaration parameters` / `Align when multiline`.     
  - (optional but recommended) open <kbd>Tabs and Indents</kbd> tab
    - change `Continuation indent` to the same value as `Indent` (4 by default).   
- <kbd>Inspections</kbd> 
  - change `Severity` level of `Unused import directive` and `Redundant semicolon` to `ERROR`.
