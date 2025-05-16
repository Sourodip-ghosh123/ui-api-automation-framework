# End-to-End UI & API Automation Framework

This Java-based BDD framework leverages Cucumber, Selenium WebDriver & RestAssured, with POM and service-layer abstractions.

**Key Achievements:**
- Automated ~90% of regression suite  
- Allure reports for each test run  
- Parallel UI execution on Docker Swarm (4 nodes) reduced pipeline runtime by ~65%  
- Cross-browser validation (Chrome & Firefox)  

## Prerequisites
- Java 11+  
- Maven 3.6+  
- Docker & Docker Swarm  
- VS Code (Java, Cucumber & Docker extensions)  
- GitHub repo for source control  

## Setup & Running

1. **Clone & open**  
```bash
git clone https://github.com/Sourodip-ghosh123/ui-api-automation-framework.git
```

2. **Build**

```bash
mvn clean install
```

3. **Init Swarm & deploy Grid**
```bash
docker swarm init
docker stack deploy -c docker/docker-compose.yml automation-grid
```

4. **Run tests**
```bash
mvn test
```

5. **View reports**
```bash
mvn allure:serve
```

6. **VS Code**
`.vscode/settings.json`: autosave & Cucumber sync
`.vscode/launch.json`: debug TestRunner

7. **CI Pipeline**
Add a `GitHub Actions` workflow under `.github/workflows/ci.yml` to run mvn test and publish Allure results.