
library identifier: 'shared-libs@master',
    // 'mylibraryname' is just an identifier, it can be anything you like
    // 'master' refers to a valid git ref (branch)
    retriever: modernSCM([
      $class: 'GitSCMSource',
      credentialsId: '', // remove this if it's public!
      remote: 'https://github.com/ashoklogicfocus/java-with-gradle.git'
])

