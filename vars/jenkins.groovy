#!/usr/bin/env groovy

@Library('sharedcode')_

sharedCodePipeline(
    projectConfigs: ["Release"],
    testDlls: ["Test/bin/Release/SpaceApe.Containers.Test.dll"],
    additionalParameters: [
        string(name: "REPO_URL", defaultValue: "${env.REPO_URL}", description: "URL of the repo"),
        string(name: "REPO_BRANCH", defaultValue: "${env.REPO_BRANCH}", description: "Branch name")
    ],
    checkoutStage: {
        checkout scm
        checkoutRepo(
            [
                url: "${env.REPO_URL}",
                branch: "${env.REPO_BRANCH}",
                directory: "repo-sub-dir"
            ]
        )
    }
)
