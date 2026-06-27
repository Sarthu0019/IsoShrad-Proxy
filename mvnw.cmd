@echo off
SET MAVEN_VERSION=3.9.6
SET MAVEN_HOME=%USERPROFILE%\.m2\wrapper\apache-maven-%MAVEN_VERSION%

if not exist "%MAVEN_HOME%\bin\mvn.cmd" (
    echo [IsoShard Build System] Local Maven binary not found. Bootstrapping environment...
    echo [IsoShard Build System] Downloading Apache Maven %MAVEN_VERSION%...
    powershell -Command "[Net.ServicePointManager]::SecurityProtocol = [Net.SecurityProtocolType]::Tls12; (New-Object System.Net.WebClient).DownloadFile('https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/%MAVEN_VERSION%/apache-maven-%MAVEN_VERSION%-bin.zip', '%TEMP%\maven.zip')"
    echo [IsoShard Build System] Unpacking architecture binaries...
    powershell -Command "Expand-Archive -Path '%TEMP%\maven.zip' -DestinationPath '%USERPROFILE%\.m2\wrapper' -Force"
    del "%TEMP%\maven.zip"
)

"%MAVEN_HOME%\bin\mvn.cmd" %*