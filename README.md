
# Jenkins Shared Library

A **Jenkins Shared Library** enables reusability of common pipeline logic across multiple Jenkins pipelines by centralizing Groovy scripts in a version-controlled repository. This guide will walk you through the process of setting up and using a Jenkins Shared Library.

## Prerequisites

Before starting, ensure you have the following:
1. A Jenkins instance with the Pipeline plugin installed.
2. A Git repository to host your shared library.
3. Administrator access to Jenkins for configuration.

---

## Step 1: Create the Jenkins Shared Library

1. **Set up a Git Repository**  
   Create a new Git repository (private or public) to store your shared library.

2. **Create the Required Directory Structure**  
   Inside the repository, maintain the following structure:

   ```bash
   (root)
   ├── vars/
   │   └── myPipeline.groovy  # Global pipeline methods
   └── README.md
   ```

   - **`vars/`**: This directory contains pipeline scripts as Groovy files. Each `.groovy` file represents a global function you can invoke within your pipelines.

3. **Add a Custom Groovy Script**  
   Create a simple Groovy script inside the `vars/` folder. For example:

   ```groovy
   // vars/myPipeline.groovy
   def call(String name = 'World') {
       echo "Hello, ${name}!"
   }
   ```

4. **Commit and Push Changes**  
   After setting up the structure and script, commit the changes and push them to your Git repository.

---

## Step 2: Configure Jenkins to Use the Shared Library

1. **Navigate to Jenkins Dashboard**  
   From the Jenkins dashboard, go to **Manage Jenkins**.

2. **Configure System**  
   Click **Configure System**, then scroll down to the **Global Pipeline Libraries** section.

3. **Add a New Shared Library**  
   - Click **Add**.
   - Provide the following details:
     - **Name**: A descriptive name for the library (e.g., `my-shared-library`).
     - **Default Version**: Specify the branch or tag to use (e.g., `main`).
     - **Retrieval Method**: Select **Modern SCM** and choose **Git**.
     - **Repository URL**: Provide the URL to your Git repository.

4. **Save the Configuration**  
   Save the changes after adding the shared library.

---

## Step 3: Use the Shared Library in a Jenkins Pipeline

To use the shared library in a pipeline, include it with the `@Library` annotation in your `Jenkinsfile`.

### Example Jenkinsfile

```groovy
@Library('my-shared-library') _

pipeline {
    agent any
    
    stages {
        stage('Greet') {
            steps {
                myPipeline('Jenkins')  // Calling the global method from the shared library
            }
        }
    }
}
```

> **Note:**  
> The `@Library('library_name') _` annotation loads the shared library.

In this example, the `myPipeline.groovy` script is invoked, which will print `Hello, Jenkins!`.

---

