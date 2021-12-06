package org.csanchez.jenkins.plugins.kubernetes.pipeline

podTemplate(yaml: '''
spec:
  containers:
  - name: busybox
    image: busybox
    command:
    - sleep
    - 99d
  terminationGracePeriodSeconds: 3
''') {
    node(POD_LABEL) {
        container('busybox') {
            sh 'sleep 9999999'
        }
    }
}
