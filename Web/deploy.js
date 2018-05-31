var s3 = require('s3');
var config = require('./deploy.config');

var client = s3.createClient({
  s3Options: {
    accessKeyId: config.AwsAccessKeyId,
    secretAccessKey: config.AwsSecretAccessKey,
    region: config.BucketRegion
  }
});

var uploader = client.uploadDir({
  localFile: "index.html",
  s3Params: {
    Bucket: config.Bucket,
    Key: "index.html",
    ACL: 'public-read'
  }
});

uploader.on('complete', function(){
    console.log(' uploaded to S3 bucket '+config.Bucket);
});
