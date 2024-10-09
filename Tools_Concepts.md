## **OWASP (Open Web Application Security Project)**
- **Purpose in Pipeline:** 
  - OWASP provides security guidelines, best practices, and tools to help secure applications, particularly focusing on the **OWASP Top 10** security risks, such as SQL Injection, Cross-Site Scripting (XSS), and Insecure Deserialization.
- **Key Role in Pipelines:**
  - Incorporates **static analysis** and security testing into CI/CD pipelines.
  - Tools like **OWASP ZAP** (Zed Attack Proxy) are commonly used for automated security scans to identify vulnerabilities in web applications during pipeline execution.

## **SonarQube**
- **Purpose in Pipeline:**
  - A tool used for **code quality** and **security analysis**, detecting bugs, code smells, and security vulnerabilities.
- **Key Role in Pipelines:**
  - Integrated into CI/CD pipelines to automatically analyze code after each build.
  - Performs **static code analysis**, ensuring code quality by enforcing standards such as maintainability, reliability, and security.
  - Provides real-time feedback to developers on **security issues** like SQL injection or XXE (XML External Entity Injection).
  - Can break the build if quality gates fail, enforcing continuous improvement.

## **Trivy**
- **Purpose in Pipeline:**
  - A **vulnerability scanner** for containers, detecting security issues in container images, file systems, and repositories.
- **Key Role in Pipelines:**
  - Integrated into CI/CD pipelines to scan Docker images before deployment.
  - Identifies vulnerabilities in both OS packages and application dependencies.
  - Ensures that only secure images are deployed by flagging **known CVEs** (Common Vulnerabilities and Exposures).
