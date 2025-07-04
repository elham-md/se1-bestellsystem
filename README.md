<<<<<<< HEAD

# Project C1: *se1-bestellsystem*

Project of a simple order processing system for the *Software Engineering-I*
course.

Class *Customer* has attributes:

- *id* (long) to identify a *Customer*,

- *lastName* and *firstName* (String) for the *Customer* name and

- contacts as List of contacts (String), e.g. *email*, *phone number*.

Classes *Order* and *Article* have also an *id* and other attributes.

<img src="https://raw.githubusercontent.com/sgra64/se1-bestellsystem/refs/heads/markup/main/Concept-diagram.png" alt="drawing" width="600"/>


**Cardinalities (dimensions)** describe whether *one* (strict: `1` or
optional: `0..1`) or *many* (zero or more: `*` or at-least one: `1..*`)
objects of one side of a relation may exist. If nothing is specified,
strict `1` is assumed.

One *Customer* may have many *Orders* - the cardinality of this relation
is: `[ 1 : * ]` (`1` with *Customer* and `*` with *Order*). In reverse
direction it reads: each *Order* is assigned exactly one *Customer*.

The relation between *Order* and *OrderItem* is: `[ 1 : 1..* ]`.
It reads: each *Order* has at least one (one or more, but at least one)
*OrderItem*. In reverse, each *OrderItem* is assigned to exactly one
*Order*.

The relation between *OrderItem* and *Article* is: `[ * : 1 ]`.
It reads: each *OrderItem* refers to exactly one *Article*. In reverse,
*Articles* may be referred to by many *OrderItems*.

**Relationships** between classes describe how classes (more precisely: their objects)
relate to one other.

- **Aggregation (white Diamond)** expresses a logical association (*"ownership"*)
    of one class to another. *Orders* are always assigned to *Customers*.
    *Orders* are not included in *Customer* objects. An *Order* cannot exist without
    the owning *Customer*.

    The *Aggregation* relationship is implemented by a reference in the "*owned*"
    class to the *"owning"* class. Class *Customer* has no information about the
    *Orders* the *Customer* owns. But each *Order* has a reference to their owning
    *Customer*.

- **Composition (black Diamond)** expresses a *"part-of"* relation. Elements of
    one class are part of another. Class *Order* contains a list of *OrderItems*.

    Since class *Order* contains *OrderItems*, this information is not included
    in *OrderItem*. Just considering an *OrderItem*, the *Order* it belongs to cannot
    be determined. Inclusion implies that *OrderItems* cannot exist without the
    containing *Order*. *OrderItem* objects are managed by the including class
    and may not need identifiers (no *id* attribute).

- **Association** (a line without diamond) expresses any other relation between
    classes that is not *"ownership"* or *"part_of"* such as between *OrderItem*
    and *Article*. An *Article* may exist without an *OrderItem*.


&nbsp;

# Project Setup: *se1-bestellsystem*

The setup-process of the order processing system for the *Software Engineering-I*
course has the following steps:

1. [Project Assembly](#1-project-assembly)

1. [Project Build & Run](#2-project-build--run)

1. [Check Project into Own Remote Repository](#3-check-project-into-own-remote-repository)

    - 3.1 [Check for *SSH-Keys* in Remote Repository](#31-check-for-ssh-keys-in-remote-repository)

    - 3.2 [Check for *SSH-Keys* on your Laptop](#32-check-for-ssh-keys-on-your-laptop)

    - 3.3 [Add Remote (Repository)](#33-add-remote-repository)

    - 3.4 [Push and Push Conflicts](#34-push-and-push-conflicts)

    - 3.5 [Local "*tracking*" Branch](#35-local-tracking-branch)

=======
>>>>>>> 9bf366bf3b74588c13f01b8164c2873a78a9a157
# C2: *Customer.java*

Steps:

1. [Branch Assembly](#1-branch-assembly)

1. [Supplement Class *Customer.java* with *Javadoc*](#2-supplement-class-customerjava-with-javadoc)

1. [Implement Class *Customer.java*](#3-implement-class-customerjava)

1. [Push Commits to your Remote Repository](#4-push-commits-to-your-remote-repository)



<<<<<<< HEAD

&nbsp;

## 1. Project Assembly

Clone branch *main* from the [*se1-play*](https://github.com/sgra64/se1-play)
repository into a new folder `"se1-bestellsystem"` into your workspace:

```sh
# clone the branch 'main' into your workspace for the new project
git clone -b main --single-branch https://github.com/sgra64/se1-bestellsystem.git


# remove the remote URL

# remove the remote URL from the project

git remote remove origin
```

Install *git sub-modules* in steps:

1. [*Install Git-Submodules*](https://github.com/sgra64/se1-gitmodules#1-install-git-submodules)

1. [*Build the libs-Submodule*](https://github.com/sgra64/se1-gitmodules#2-build-the-libs-submodule)


Verify the project content:

```sh
ls -la                              # show content of the project directory
```
```
total 45
drwxr-xr-x 1    0 May 25 22:54 ./
drwxr-xr-x 1    0 May 25 22:25 ../
drwxr-xr-x 1    0 May 25 22:51 .env/            <-- git-submodule '.env'
drwxr-xr-x 1    0 May 25 22:36 .git/            <-- local git repository
-rw-r--r-- 1 1257 May 25 20:41 .gitignore
-rw-r--r-- 1  304 May 25 21:04 .gitmodules

-rw-r--r-- 1 3045 Jun  3 20:16 .gitmodules.sh

drwxr-xr-x 1    0 May 25 22:54 .vscode/         <-- git-submodule '.vscode'
drwxr-xr-x 1    0 May 25 22:19 libs/            <-- git-submodule 'libs'
-rw-r--r-- 1 8347 May 25 22:54 README.md
drwxr-xr-x 1    0 May 25 21:53 resources/       <-- none-Java source code
drwxr-xr-x 1    0 May 25 20:13 src/             <-- Java source code
drwxr-xr-x 1    0 May 25 21:53 tests/           <-- Java JUnit test code
```


Source the project:

=======
&nbsp;

>>>>>>> 9bf366bf3b74588c13f01b8164c2873a78a9a157
## 1. Branch Assembly

Tag the latest commit on branch `main` with `"base"`.

Create a new branch: `c12-customer` to implement the class: *Customer.java*.

Set a new remote with name: `se1-remote` pointing to the remote repository
from where the branch will be pulled:

```sh
git remote add se1-remote https://github.com/sgra64/se1-bestellsystem.git

git remote -v                   # show all remotes
```

Output will show two remotes: *"origin"* pointing to your remote repository
and the new remote: *"se1-remote"* :

```
origin  git@gitlab.bht-berlin.de:<your-name>/se1-bestellsystem.git (fetch)
origin  git@gitlab.bht-berlin.de:<your-name>/se1-bestellsystem.git (push)
se1-remote      https://github.com/sgra64/se1-bestellsystem.git (fetch)
se1-remote      https://github.com/sgra64/se1-bestellsystem.git (push)
```

Pull remote branch `se1-remote/c12-customer` into the new local
branch `c12-customer`:

```sh
# pull the remote branch (pull: fetch + merge), --strategy-option theirs
git pull se1-remote c12-customer \
    --squash --allow-unrelated-histories
```

Commit the changes that arrived with the pull:

```sh
git commit -m "pull se1-remote c12-customer"
```

A new class [*Application_C12.java*](src/application/Application_C12.java)
has been added to package `application`, which creates and prints some
*Customer* objects:

```java
/**
 * Run application code on an instance rather than in {@code static main();}
 */
@Override
public void run(String[] args) {
    // 
    final Customer eric = new Customer("Eric Meyer")
        .setId(892474L)     // set id, first time
        .setId(947L)        // ignored, since id can only be set once
        .addContact("eric98@yahoo.com")
        .addContact("eric98@yahoo.com") // ignore duplicate contact
        .addContact("(030) 3945-642298");

    final Customer anne = new Customer("Bayer, Anne")
        .setId(643270L)
        .addContact("anne24@yahoo.de")
        .addContact("(030) 3481-23352")
        .addContact("fax: (030)23451356");

    final Customer tim = new Customer("Tim Schulz-Mueller")
        .setId(286516L)
        .addContact("tim2346@gmx.de");

    final Customer nadine = new Customer("Nadine-Ulla Blumenfeld")
        .setId(412396L)
        .addContact("+49 152-92454");

    final Customer khaled = new Customer()
        .setName("Khaled Saad Mohamed Abdelalim")
        .setId(456454L)
        .addContact("+49 1524-12948210");

    final TableFormatter tf = new TableFormatter("|%-6s", "| %-32s", "| %-32s |")
        .line()
        .row("ID", "NAME", "CONTACTS")  // table header
        .line();

    final List<Customer> customers = List.of(eric, anne, tim, nadine, khaled);
}
```

Compile and run the code:

```sh
mk compile run                      # compile and run the code
```

Output shows an empty table since class *Customer* is still incomplete:

```
Hello, se1.bestellsystem (Application_C12, modular)
+------+---------------------------------+----------------------------------+
|ID    | NAME                            | CONTACTS                         |
+------+---------------------------------+----------------------------------+
|0     | ,                               |                                  |
|0     | ,                               |                                  |
|0     | ,                               |                                  |
|0     | ,                               |                                  |
|0     | ,                               |                                  |
+------+---------------------------------+----------------------------------+
```



<<<<<<< HEAD

&nbsp;


## 2. Project Build & Run

Source the project to set the environment:


```sh
ln -s .env/env.sh .env.sh           # set symbolic link to sourcing script

source .env.sh                      # source the project
```


=======
&nbsp;

>>>>>>> 9bf366bf3b74588c13f01b8164c2873a78a9a157
## 2. Supplement Class *Customer.java* with *Javadoc*

Create class `Customer.java` in package `datamodel` from the *UML Class Diagram:* 

<img src="https://raw.githubusercontent.com/sgra64/se1-bestellsystem/refs/heads/markup/main/Class-customer.png" alt="drawing" width="400"/>

Follow steps:

1. Create an empty class `Customer.java` in package `datamodel`.

1. Add *attributes*, *constructors* and *methods* as specified.

1. Add [*Javadoc*](https://en.wikipedia.org/wiki/Javadoc) from the documentation
    of class [*Customer.java*](https://sgra64.github.io/se1-bestellsystem/c12-customer)
    to understand methods and their expected behavior.

Understand particularly the purpose of method
[*splitName(String name)*](https://sgra64.github.io/se1-bestellsystem/c12-customer/se1.bestellsystem/datamodel/Customer.html#splitName(java.lang.String))
that splits a single-String name, e.g. "Meyer, Eric" into its first and last name parts.

Rebuild *Javadoc* locally:

```sh
mk javadoc                      # build Javadoc for the project
```
```
javadoc -d docs $(eval echo $JDK_JAVADOC_OPTIONS) \
  $(builtin cd src; find . -type d | sed -e 's!/!.!g' -e 's/^[.]*//')
Loading source files for package application...
Loading source files for package datamodel...
Constructing Javadoc information...
Creating destination directory: "docs\"
Building index for all the packages and classes...
Standard Doclet version 21+35-LTS-2513
Building tree for all the packages and classes...
Generating docs\se1.bestellsystem\application\Application.html...
Generating docs\se1.bestellsystem\application\Application_C12.html...
Generating docs\se1.bestellsystem\datamodel\Customer.html...
Generating docs\se1.bestellsystem\application\Runner.html...
Generating docs\se1.bestellsystem\application\package-summary.html...
Generating docs\se1.bestellsystem\application\package-tree.html...
Generating docs\se1.bestellsystem\datamodel\package-summary.html...
Generating docs\se1.bestellsystem\datamodel\package-tree.html...
Generating docs\se1.bestellsystem\module-summary.html...
Generating docs\overview-tree.html...
Building index for all classes...
Generating docs\allclasses-index.html...
Generating docs\allpackages-index.html...
Generating docs\index-all.html...
Generating docs\search.html...
Generating docs\index.html...
Generating docs\help-doc.html...
```

Fix errors and warnings when *Javadoc* compiles.

Open file: `docs/index.html` in a browser, navigate to class *Customer.java* and
compare with the *Javadoc* in
[*Customer.java*](https://sgra64.github.io/se1-bestellsystem/c12-customer/se1.bestellsystem/datamodel/Customer.html)

Both should be identical, except for the `Autor:` tag, which should show your name.



<<<<<<< HEAD

&nbsp;


## 2. Project Build & Run


Build and run the project:

```sh
mk compile run A BB CCC             # build & run the project
```
```
Hello, se1.bestellsystem (Application, modular)
 - arg: A
 - arg: BB
 - arg: CCC
```

Build and run tests:

```sh
mk compile-tests run-tests          # build & run JUnit tests
```
```
├─ JUnit Jupiter ✔
│  └─ Application_0_always_pass_Tests ✔
│     ├─ test_001_always_pass() ✔
│     └─ test_002_always_pass() ✔
├─ JUnit Vintage ✔
└─ JUnit Platform Suite ✔

Test run finished after 166 ms
[         4 containers found      ]
[         0 containers skipped    ]
[         4 containers started    ]
[         0 containers aborted    ]
[         4 containers successful ]
[         0 containers failed     ]
[         2 tests found           ]
[         0 tests skipped         ]
[         2 tests started         ]
[         0 tests aborted         ]
[         2 tests successful      ]
[         0 tests failed          ]
```


Package the project to a `.jar` file:

```sh
mk package                          # package the project
```
```
tar cv libs/{jackson,logging}*/* | tar -C bin -xvf - ;
jar -c -v -f bin/application-1.0.0-SNAPSHOT.jar \
      -m resources/META-INF/MANIFEST.MF \
      -C bin/classes . ;
libs/jackson/jackson-annotations-2.19.0.jar
libs/jackson/jackson-core-2.19.0.jar
libs/jackson/jackson-annotations-2.19.0.jar
libs/jackson/jackson-core-2.19.0.jar
libs/jackson/jackson-databind-2.19.0.jar
libs/jackson/jackson-databind-2.19.0.jar
libs/logging/log4j-api-2.24.3.jar
libs/logging/log4j-api-2.24.3.jar
libs/logging/log4j-core-2.24.3.jar
libs/logging/log4j-core-2.24.3.jar
libs/logging/log4j-slf4j2-impl-2.24.3.jar
libs/logging/slf4j-api-2.0.17.jar
libs/logging/log4j-slf4j2-impl-2.24.3.jar
libs/logging/slf4j-api-2.0.17.jar
added manifest
added module-info: module-info.class
adding: application/(in = 0) (out= 0)(stored 0%)

adding: application/Application.class(in = 2753) (out= 1263)(deflated 54%)
adding: application/Runner.class(in = 144) (out= 124)(deflated 13%)
adding: application/package-info.class(in = 117) (out= 101)(deflated 13%)
adding: application/package_info.class(in = 333) (out= 260)(deflated 21%)
adding: application/Application.class(in = 2629) (out= 1208)(deflated 54%)
adding: application/Runner.class(in = 144) (out= 124)(deflated 13%)
adding: application/package_info.class(in = 333) (out= 261)(deflated 21%)

```

Show and run the packaged `.jar` file:

```sh
ls -la bin                          # the '.jar' is in the 'bin' directory
```
```
total 12
drwxr-xr-x 1 svgr2 Kein    0 May 25 23:00 .
drwxr-xr-x 1 svgr2 Kein    0 May 25 22:56 ..
-rw-r--r-- 1 svgr2 Kein 3245 May 25 23:00 application-1.0.0-SNAPSHOT.jar
drwxr-xr-x 1 svgr2 Kein    0 May 25 22:56 classes
drwxr-xr-x 1 svgr2 Kein    0 May 25 23:00 libs
drwxr-xr-x 1 svgr2 Kein    0 May 25 21:53 resources
drwxr-xr-x 1 svgr2 Kein    0 May 25 22:56 test-classes
```

Run the `.jar` file:

```sh
java -jar bin/application-1.0.0-SNAPSHOT.jar A BB CCC
```
```
Hello, se1-bestellsystem (Application)
 - arg: A
 - arg: BB
 - arg: CCC
```

Create the Java documentation:

```sh
mk javadoc                          # create javadoc
```

Open the documentation: `docs/index.html` and show that your name appears
on pages as `Author: <your name>`. The name is defined in file
[*application.package-info.java*](src/application/package-info.java).



&nbsp;

## 3. Check Project into Own Remote Repository

Create a new project with name: *"se1-bestellsystem"* in your
[*BHT GitLab*](https://gitlab.bht-berlin.de/)
or other repository, e.g. at [*GitHub*](https://github.com/).


### 3.1 Check for *SSH-Keys* in Remote Repository

Make sure, you have a `public ssh key` registered in your *Git* account.

You find registered public keys in

- *GitLab* at section: [*SSH Keys*](https://gitlab.bht-berlin.de/-/user_settings/ssh_keys)
  - reached through: `<personal> -> User Settings -> SSH Keys` (start at small
    sidebar icon in the upper left).

- *GitHub* at section: [*SSH Keys*](https://github.com/settings/keys)
  - reached through: `<personal> -> Settings -> SSH Keys`.


### 3.2 Check for *SSH-Keys* on your Laptop

Check you have a public/private SSH key pair installed in your $HOME
directory:

```sh
cd $HOME                            # change to $HOME directory
ls -la                              # list content
```

A directory `.ssh` should appear among other entries:

```
total 159
drwxr-xr-x 1     0 Jun  1 18:47 ./
drwxr-xr-x 1     0 Mar 22 11:50 ../
...
drwxr-xr-x 1     0 Mar 17 19:42 .ssh/       <-- directory with SSH key pairs
```

If you don't have `.ssh` in $HOME, create with the following command using the default
settings (don't put a password on your keys):

```sh
ssh-keygen                          # create SSH keys in '.ssh' directory
```

Show content:

```sh
ls -la .ssh                         # list content of '.ssh' directory
```
```
total 40
drwxr-xr-x 1    0 Mar 17 19:42 ./
drwxr-xr-x 1    0 Jun  1 18:47 ../
-rw-r--r-- 1 1679 Mar 17 19:42 id_rsa       <-- file with private key
-rw-r--r-- 1  415 Mar 17 19:42 id_rsa.pub   <-- file with public key
```

Show the content of the public key file `id_rsa.pub` (default name):

```sh
cat .ssh/id_rsa.pub                 # show content of public key file
```
```
ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQDsYvrIXtdlPGjByzFbB2S/AgjFzaWCBQ+cot7rrXDLMWJHH+uyWNbh0QpXGtTPm43XXH6hx004ew3cv52k5atqeJgkKGPLb3Zzp9Kg1yVQg5u2dntuzPW8ghwLKdVkHPoYLSLrj/ivYXYqrqsahJ0Nt0QSgjNQ/BUJvLaWXpXGP2EKT5f2S5un61Sdw0u37z5n/KnGOUtwAcG+cJn7b/5BP7REC+HI6v8/RLtCN36vN7Mz+nUio2btFIFmkxSjnxj8G/y4318V9mf7p1W7jTZ9Pcc2ku41yz9JNBl/E4YyVJvEjTO/4yEJ/4AYSDnkL2g57chRhliw5pmVtzONCwX7 sven.graupner@beuth-hochschule.de
```

Show the content of the private key file `id_rsa` (default name):

```sh
cat .ssh/id_rsa                     # show content of private key file
```

Output should of the private key file `id_rsa` should always stay protected on
your laptop. Its possession in combination with the public key enables anybody
to act on your behalf.


### 3.3 Add Remote (Repository)

Obtain the *ssh*-repository URL from the GitLab project site, e.g.
`git@gitlab.bht-berlin.de:<your-id>/se1.bestellsystem.git`
and register the name `origin` as new remote repository:

```sh
# register the remote repository URL under the name 'origin'
# make sure to replace the '<...>' with your account id
git remote add origin git@gitlab.bht-berlin.de:<...>/se1.bestellsystem.git

# show the new remote URL
git remote -v
```

The new URL is registered under name `origin`.

```
origin  git@gitlab.bht-berlin.de/se1-bestellsystem.git (fetch)
origin  git@gitlab.bht-berlin.de/se1-bestellsystem.git (push)
se1-patch-repository    https://github.com/sgra64/se1-bestellsystem.git (fetch)
se1-patch-repository    https://github.com/sgra64/se1-bestellsystem.git (push)
```

Show the new remote URL in file `.git/config`:

```
[core]
        repositoryformatversion = 0
        filemode = false
        bare = false
        logallrefupdates = true
        ignorecase = true
[remote "origin"]               <-- new remote URL
        url = git@gitlab.bht-berlin.de/se1-bestellsystem.git
        fetch = +refs/heads/*:refs/remotes/origin/*
```


### 3.4 Push and Push Conflicts

The local `main` branch can now be pushed to the corresponding remote branch
`origin main`.

The two branches:

- the local `main` branch and the

- corresponding remote branch `origin main`

will be linked as "*tracking branch*" and "*tracked branch*".
The local branch `main` will track the remote branch `origin main`.


```sh
git push --set-upstream origin main     # push branch 'main' to remote 'origin'

# or as short version:
git push -u origin main                 # short for pushing the local branch 'main'
```

If the *push* fails with an error:

```
$ git push

 ! [rejected]        main -> main (fetch first)
error: failed to push some refs to 'git@gitlab.bht-berlin.de/se1-bestellsystem.git'
hint: Updates were rejected because the remote contains work that you do
hint: not have locally. This is usually caused by another repository pushing
hint: to the same ref. You may want to first merge the remote changes (e.g.,
hint: 'git pull') before pushing again.
```

the branch in the remote repository has commits that are not yet in the local
branch.

Unlike *GitHub*, *GitLab* does not create a new repository *empty*. It creates
an initial commit causing a
[*Push Conflict*](https://charlesreid1.com/wiki/Git/Resolving_Push_Conflicts).

1. Branches pushed to remote repositories are meant to be shared with other developers.
    Hence, other developers can pull and commit to those branches as well.
    **Remote branches can grow without your awareness**.

1. ***Git* synchronizes commit chains,** which means it will not allow commits
    being pushed **(Push Conflict)** that are not based on the latest commit
    on the remote branch.

1. Git does **not automatically synchronize branches**.
    Hence, before you can push your commits, you must **pull**
    (pull: fetch + merge) commits others have made on the remote branch.

1. **Git pull will merge commits** others have made into your work creating
    a new (merge-) commit that is now the latest commit of the chain can
    **can be pushed** -- unless someone else has made further commits in the
    mean time, then the process repeats.

Resolve the push conflict by *pulling* missing commits from the remote branch:

```sh
git push --set-upstream origin main     # push branch 'main' to remote 'origin'

# or as short version:
git push -u origin main                 # short for pushing the local branch 'main'
```


### 3.5 Local "*tracking*" Branch

With the push of the `main` branch to the remote, the local branch `main` has
become a local "*tracking*" branch of the remote branch, which means further
*pulls* will refer to the remote ("*tracked*") branch.

```sh
git branch -avv                         # show all remote and local tracking branches
```
```
* main                        7bc247f [origin/main] add README.md
  remotes/origin/main         7bc247f add README.md
```

Label `[origin/main]` (in blue color) shows the association of the local
`main` branch with the remote *"tracked"* branch `origin/main`.

Further commands will refer to the associated remote tracked branch:

```sh
# both commands refer to the associated remote "tracked" branch
git pull
pit push
```

=======
&nbsp;

>>>>>>> 9bf366bf3b74588c13f01b8164c2873a78a9a157
## 3. Implement Class *Customer.java*

Implement methods according to the *Javadoc* specifications.
Pay attention return values and behavior for illegal arguments.

After implementation, re-compile and run the code. The table now shows the
created *Customer* objects:

```sh
mk compile run                      # compile and run the code
```
```
Hello, se1.bestellsystem (Application_C12, modular)
+------+---------------------------------+----------------------------------+
|ID    | NAME                            | CONTACTS                         |
+------+---------------------------------+----------------------------------+
|892474| Meyer, Eric                     | eric98@yahoo.com, (+1 contacts)  |
|643270| Bayer, Anne                     | anne24@yahoo.de, (+2 contacts)   |
|286516| Schulz-Mueller, Tim             | tim2346@gmx.de                   |
|412396| Blumenfeld, Nadine-Ulla         | +49 152-92454                    |
|456454| Abdelalim, Khaled Saad Mohamed  | +49 1524-12948210                |
+------+---------------------------------+----------------------------------+
```

Commit changes under `c12: Customer.java`.

Show commit log:

```sh
git log --oneline                   # show commit log
```
```
340e59f (HEAD -> main) c12: Customer.java       <-- latest commit
b1e8439 pull se1-remote c12-customer
aad5b4a add .gitmodules file and modules .env, .vscode, libs
44cdf9f add README.md
c43f7e1 add src, tests, resources
638c570 add .gitmodules, .gitmodules.sh
d8f0873 add .gitignore
4375dd3 (tag: root) root commit (empty)
```



&nbsp;

## 4. Push Commits to your Remote Repository

When tests are passing and Javadoc has been sucessfully created:

1. commit changes on your local branch `c12-customer`.

1. Push the branch to your remote repository.

1. Merge branch `c12-customer` to your local `main` branch.

1. Push branch `main` also to your remote repository.
<<<<<<< HEAD

=======
>>>>>>> 9bf366bf3b74588c13f01b8164c2873a78a9a157
