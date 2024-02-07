## SDDF Workshop day 3

```
mvn archetype:generate -DgroupId=sg.edu.nus.iss -DartifactId=sdfworkshop3 -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
```

```
cd sdfworkshop3
```

```
mvn clean compile //Compile
mvn package //Create jar
java -cp target/sdfworkshop3-1.0-SNAPSHOT.jar sg.edu.nus.iss.App //Run jar
```

```
git checkout -b shoppingcart
git push origin shoppingcart
```

```
git checkout main //Go back to main branch (can use git branch to double check)
git merge shoppingcart
git add .
git commit -m "message"
git push origin main
```
